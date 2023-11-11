def main():
    with open("schedule.xml", encoding="utf-8") as f:
        f = '<wml>' + f.read() + '</wml>'

    with open("schedule3.wml", 'w') as f2:
        print(f, file=f2)


if __name__ == '__main__':
    main()
