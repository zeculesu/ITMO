import re


def count_smile(pattern, line):
    return len(re.findall(pattern, line))


def remove_repetitions(line):
    new_text = line
    for word in line.split():
        new_text = re.sub(rf"({word}\s+{word})(\W)", rf"{word}\2", new_text)
    return new_text


def task1():
    smile_pattern = ';<P'
    tests = [["Simple ;<P happening", 1],
             ["More;<Pdifficult;<P", 2],
             ["That's about ;<Port", 1],
             ["M;<PO;<PRE;<P", 3],
             [";<P mm ;<P;<P;<P so ma;<Pny ;<P;<P;<P", 8]]

    print('Task 1')
    for i, test in enumerate(tests):
        print(f"Test #{i+1}", count_smile(smile_pattern, test[0]) == test[1])


def task2():
    pass

def task3():
    pass


if __name__ == '__main__':
    task1()
    task2()