import re


def count_smile(pattern, line):
    return len(re.findall(pattern, line))


def remove_repetitions(line):
    new_text = line
    for word in line.split():
        new_text = re.sub(rf"({word}\s+{word})(\W)", rf"{word}\2", new_text)
    return new_text


def delete_people_repeating_initials(group, people):
    new_people = []
    for man in people:
        lit = man[0]
        if not re.fullmatch(rf'{lit}\w+\s{lit}.{lit}.\s{group}', man) and not re.fullmatch(
                rf'{lit}\w+-{lit}\w+\s{lit}.{lit}.\s{group}', man):
            new_people.append(man)
    return new_people


def task1():
    smile_pattern = ';<P'
    tests = [["Simple ;<P happening", 1],
             ["More;<Pdifficult;<P", 2],
             ["That's about ;<Port", 1],
             ["M;<PO;<PRE;<P", 3],
             [";<P mm ;<P;<P;<P so ma;<Pny ;<P;<P;<P", 8]]

    print('Task 1')
    for i, test in enumerate(tests):
        print(f"Test #{i + 1}", count_smile(smile_pattern, test[0]) == test[1])


def task2():
    pass


def task3(group, people):
    pass


if __name__ == '__main__':
    print(delete_people_repeating_initials("P0000", ["Петров П.П. P0000",
                                                      "Анищенко А.А. P33113",
                                                      "Примеров Е.В. P0000",
                                                      "Иванов-Ива И.И. P0000"
                                                      ]))
