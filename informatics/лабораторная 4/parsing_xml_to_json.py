def join_dict(dicts: list) -> dict:
    new = {}
    for dd in dicts:
        for key, value in dd.items():
            new[key] = value
    return new


def del_line_emptiness(tags: list):
    for el in tags:
        if el.isspace():
            tags.remove(el)
    return tags


def find_tag(line: str) -> list:
    tags = []
    st_tag, text = 0, ''
    for i in range(len(line)):
        if line[i] == "<":
            if text:
                tags.append(text)
                text = ""
            st_tag = i + 1
        elif line[i] == ">":
            tags.append(line[st_tag - 1:i + 1])
            st_tag = 0
        elif line[i - 1] == ">" or text != '':
            text += line[i]
    return del_line_emptiness(tags)


def is_tag(line: str) -> bool:
    return line[0] == "<" and line[-1] == ">"


def get_tag(tag):
    return tag[2:len(tag) - 1] if '</' in tag else tag[1:len(tag) - 1]


def check_pars(tag1, tag2):
    return tag1[1:][:-1].split()[0] == get_tag(tag2) or tag2[1:][:-1].split()[0] == get_tag(tag1)


def make_json(tags):
    if len(tags) == 3:
        return {get_tag(tags[0]): tags[1]}
    elif check_pars(tags[0], tags[-1]) and not tags.count(tags[0]) > 1:
        nn = make_json(tags[1:len(tags) - 1])
        if type(nn) == list:
            if len(set([k for el in nn for k in el])) == 1:
                keyy = [el for el in nn[0]][0]
                dd = {keyy: [k[keyy] for k in nn]}
                tags = [tags[0], dd, tags[-1]]
        else:
            tags = [tags[0], nn, tags[-1]]
        return make_json(tags)
    else:
        i = 0
        while any(type(el) == str for el in tags):
            if is_tag(tags[i]) and not is_tag(tags[i + 1]) and check_pars(tags[i + 2], tags[i]):
                tags = [*tags[:i], {get_tag(tags[i]): tags[i + 1]}, *tags[i + 3:]]
            else:
                j = i + 1
                while not check_pars(tags[j], tags[i]):
                    j += 1
                tags = [*tags[:i], {get_tag(tags[i]): join_dict(make_json(tags[i + 1:j]))}, *tags[j + 1:]]
            i = (i + 1) % len(tags)
        return tags


def main():
    with open("schedule.xml", encoding="utf-8") as f:
        f = make_json(find_tag(f.read()))

    with open("schedule1.json", 'w') as f2:
        for k in f:
            print(f'{{"{k}": {f[k]}}}'.replace("'", '"'), file=f2)


if __name__ == '__main__':
    main()
