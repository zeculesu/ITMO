def iter_pow_2():
    x = 1
    while True:
        yield x
        x *= 2


def iter_info():
    j = 0
    for i in iter_pow_2():
        while j < i - 1:
            yield j
            j += 1
        j += 1


def iter_period_indices(size):
    i = -1
    while True:
        i += size
        for _ in range(size):
            yield i
            i += 1


def iter_stop(size, it):
    for i in it:
        if i >= size:
            break
        yield i


def iter_ignore_first(it):
    it = iter(it)
    for _ in it:
        break
    else:
        return
    yield from it


def get_corrupted_bit_index(s):
    k = -1
    for p in iter_stop(len(s), iter_pow_2()):
        r = 0
        for i in iter_ignore_first(iter_stop(len(s), iter_period_indices(p))):
            r ^= s[i]
        if s[p - 1] != r:
            k += p
    return k


def get_correct_code(message, mistake):
    new_message = ''
    for i in iter_stop(len(message), iter_info()):
        if i == mistake:
            new_message += str(int(not message[i]))
        else:
            new_message += str(int(message[i]))
    return new_message


if __name__ == '__main__':
    s = list(map(bool, map(int, input())))
    print("correct message", get_correct_code(s, get_corrupted_bit_index(s)))
