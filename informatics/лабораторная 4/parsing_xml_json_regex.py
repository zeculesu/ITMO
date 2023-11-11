import re


def join_dict(dicts: list) -> dict:
    if len(dicts) == 1:
        return dicts
    new = {}
    for d in dicts:
        k = next(iter(d))
        if k not in new:
            new[k] = d[k]
        else:
            new[k] = [new[k], d[k]]
    return new


def get_text(line: list) -> list:
    return [re.sub(rf'>.+<', word[1:][:-1], word) for word in line]


def find_tag(line: str) -> list:
    pattern = re.compile(r'<[^<>]+>|</\w+>|>.+<')
    return get_text([pattern.match(line[i:]).group() for i in range(len(line) - 1) if pattern.match(line[i:])])


def is_tag(line: str) -> bool:
    return True if re.fullmatch(r'<[^<>]+>|</\w+>', line) else False


def get_tag(tag):
    return tag[2:len(tag) - 1] if '</' in tag else tag[1:len(tag) - 1]


def check_pars(tag1, tag2):
    if not is_tag(tag1) or not is_tag(tag2):
        return False
    return tag1[1:][:-1].split()[0] == get_tag(tag2) or tag2[1:][:-1].split()[0] == get_tag(tag1)


def have_repeat_tag(tags, kk):
    kk = kk[1:][:-1].split()[0]
    i = 0
    for tag in tags:
        if re.fullmatch(rf'<{kk} .+>|<{kk}>', tag):
            i += 1
        if i > 1:
            return True
    return False


def have_extra_information(tag: str) -> bool:
    if len(tag.split()) > 1:
        return True
    return False


def get_extra_information(tag: str) -> dict:
    info = {}
    for el in tag.split()[1:]:
        k, v = el.split("=")
        info["@" + k] = v[1:][:-1]
    return info


def get_tag_without_info(tag: str) -> str:
    return tag.split()[0]


def make_dict(key, value):
    tag = get_tag(key)
    if have_extra_information(tag):
        tag_new = get_tag_without_info(tag)
        dd = get_extra_information(tag) | value
        nn = {tag_new: dd}
    else:
        nn = {tag: value}
    return nn


def make_json(tags):
    if len(tags) == 3:
        return make_dict(tags[0], tags[1])
    if check_pars(tags[0], tags[-1]) and not have_repeat_tag(tags, tags[0]):
        nn = make_json(tags[1:len(tags) - 1])
        if type(nn) == list:
            tags = [tags[0], join_dict(nn), tags[-1]]
        else:
            tags = [tags[0], nn, tags[-1]]
        return make_json(tags)
    else:
        i = 0
        while any(type(el) == str for el in tags):
            if is_tag(tags[i]) and not is_tag(tags[i + 1]) and check_pars(tags[i + 2], tags[i]):
                tags = [*tags[:i], make_dict(tags[i], tags[i + 1]), *tags[i + 3:]]
            else:
                j = i + 1
                while not check_pars(tags[j], tags[i]):
                    j += 1
                tags = [*tags[:i], make_dict(tags[i], join_dict(make_json(tags[i + 1:j]))), *tags[j + 1:]]
            i = (i + 1) % len(tags)
        return tags


def main():
    with open("schedule.xml", encoding="utf-8") as f:
        f = make_json(find_tag(f.read()))

    with open("schedule2.json", 'w') as f2:
        for k in f:
            print(f'{{"{k}": {f[k]}}}'.replace("'", '"'), file=f2)


if __name__ == '__main__':
    main()