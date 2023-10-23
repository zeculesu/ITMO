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
        if not re.fullmatch(rf'{lit}\w+\s{lit}[.]{lit}[.]\s{group}', man) and not re.fullmatch(
                rf'{lit}\w+-{lit}\w+\s{lit}[.]{lit}[.]\s{group}', man):
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
    tests = [['Искать повторы повторы сложная задача задача, поэтому автоматизируем',
              "Искать повторы сложная задача, поэтому автоматизируем"],
             ["Те кто кто водят хороводы хороводоводы", "Те кто водят хороводы хороводоводы"],
             ["42 — ответ на на главный вопрос жизни, вселенной вселенной и всего такого такого.",
              "42 — ответ на главный вопрос жизни, вселенной и всего такого."],
             ["Двойные отрицания не не не это сложно, но тройные тройные ещё хуже",
              "Двойные отрицания не это сложно, но тройные ещё хуже"],
             [
                 "Я к вам пишу пишу — чего же же боле? Что я могу могу могу еще сказать? Теперь, я знаю знаю, в вашей воле Меня Меня презреньем наказать.",
                 "Я к вам пишу — чего же боле? Что я могу еще сказать? Теперь, я знаю, в вашей воле Меня презреньем наказать."]]

    print('Task 2')
    for i, test in enumerate(tests):
        print(f"Test #{i + 1}", remove_repetitions(test[0]) == test[1])


def task3():
    tests = [[["P0000", ["Петров П.П. P0000",
                         "Анищенко А.А. P33113",
                         "Примеров Е.В. P0000",
                         "Иванов И.И. P0000"
                         ]], [
                  "Анищенко А.А. P33113",
                  "Примеров Е.В. P0000"]
              ],
             [["P3131", ["Артемченко А.А. P3131",
                         "Зажигин З.А. P3131",
                         "Беспалов Б.Б. P3130"]], [
                  "Зажигин З.А. P3131",
                  "Беспалов Б.Б. P3130"]
              ],
             [["P2540", ["Артемченко-Амузинский А.А. P2540",
                         "Павлов П.П. P2540",
                         "Онегин Б.З. P3130",
                         "Леонов А.Л. P2540"]],
              [
                  "Онегин Б.З. P3130",
                  "Леонов А.Л. P2540"]
              ],
             [["P2540", ["Артемченко-Ильинский А.А. P2540",
                         "Павлов П.П. P2540",
                         "Онегин Б.З. P3130",
                         "Леонов А.Л. P2540"]], [
                  "Артемченко-Ильинский А.А. P2540",
                  "Онегин Б.З. P3130",
                  "Леонов А.Л. P2540"]],
             [["P2000", ["Котов К.К. P2000",
                         "Бескрылов Б.П. P2000",
                         "Шашкин Ш.Ш. P2001"]], [
                  "Бескрылов Б.П. P2000",
                  "Шашкин Ш.Ш. P2001"]]]

    print('Task 3')
    for i, test in enumerate(tests):
        print(f"Test #{i + 1}", delete_people_repeating_initials(test[0][0], test[0][1]) == test[1])


if __name__ == '__main__':
    task1()
    task2()
    task3()
