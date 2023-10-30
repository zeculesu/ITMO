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


def istag(line: str) -> bool:
    return line[0] == "<" and line[-1] == ">"


def make_json(tags):
    if len(tags) == 3:
        return {tags[0]: tags[1]}
    if tags[0] == tags[-1].replace('/', ''):
        tags = [tags[0], make_json(tags[1:len(tags)-1]), tags[-1]]
        return make_json(tags)
    else:
        i = 0
        while any(type(el) == str for el in tags):
            if istag(tags[i]) and not istag(tags[i + 1]) and tags[i+2] == tags[i][0] + "/" + tags[i][1:]:
                new = {tags[i]: tags[i+1]}
                tags = [*tags[:i], new, *tags[i+3:]]
            i = (i + 1) % len(tags)
        return tags


#s = '<class1><time>10:00-11:30</time><auditorium>Ауд. Актовый зал (1216/0 (усл)), ул.Ломоносова, д.9, лит. М</auditorium><subject>Программирование</subject><lector>Письмак Алексей Евгеньевич</lector><format>Очно</format></class1>'  # -> time: "-+-"
#s = '<class1><time>10:00-11:30</time><auditorium>Ауд. Актовый зал (1216/0 (усл)), ул.Ломоносова, д.9, лит. М</auditorium></class1>'
#s = find_tag(s)
#print(make_json(s))
with open("schedule.xml", encoding="utf-8") as f:
    f = f.read()
    f = find_tag(f)
    print(make_json(f))
