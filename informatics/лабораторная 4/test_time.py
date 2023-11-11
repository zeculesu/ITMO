import parsing_with_module
import parsing_xml_to_json
import parsing_xml_json_regex
from time import time

print("Тест времени для кода основого задания")
st = time()
for i in range(100):
    parsing_xml_to_json.main()
end = time()
print("Время -", end - st)
print()
print("Тест времени для кода с использованием regex")
st = time()
for i in range(100):
    parsing_xml_json_regex.main()
end = time()
print("Время -", end - st)
print()
print("Тест времени для кода с использованием библиотеки")
st = time()
for i in range(100):
    parsing_with_module.main()
end = time()
print("Время -", end - st)
