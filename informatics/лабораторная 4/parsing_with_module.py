import json
import xmltodict


with open("schedule.xml", encoding="utf-8") as xml_file:
    data_dict = xmltodict.parse(xml_file.read())
json_data = json.dumps(data_dict, ensure_ascii=False)
with open("data.json", "w", encoding="utf-8") as json_file:
    json_file.write(json_data)