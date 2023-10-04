#!/bin/bash

#временный костыль УБРАТЬ
chmod -R u+rwx lab0
rm -Rf lab0
mkdir lab0
cd lab0

#ЗАДАНИЕ 1
mkdir -p mienfoo0/nidoranF mienfoo0/carvanha weezing1/shellder weezing1/hypno zweilous3/prinplup zweilous3/snorlax
echo "Развитые способности Sheer Force" >>  hariyama4
echo -e "Развитые\nспособности Rattled Moxie" >> mienfoo0/mightyena
echo -e "Ходы Astonish Dark Pulse\nDefense Curl Double-Edge Foul Play Heal Bell Hyper Voice Icy Wind\nOminous Wind Lucky Chant Magic Coat Magical Leaf Pain Split Psywave\nRole Play Shock Wave Skill Swap Sleep Talk Snatch Snore Spite Sucker\nPunch Swift Trick Uproar Wonder Room" >> mismagius9
echo -e "weight=4,6 height=20.0\natk=9 def=4" >> murkrow5
echo "Живет Cave Mountain Taiga" >> weezing1/ursaring
echo -e "Ходы Aqua Tail Bind Gastro Acid Giga Drain Grass\nPledge Iron Tail Knock Off Seed Bomb Sleep Talk Snatch Snore Synthesis\nWorry Seed" >> weezing1/snivy
echo -e "Развитые\nспособности Heaxy Metal" >> zweilous3/bronzor

#ЗАДАНИЕ 2
chmod 006 hariyama4

chmod 064 mienfoo0/mightyena
chmod 752 mienfoo0/nidoranF
chmod 764 mienfoo0/carvanha
chmod 570 mienfoo0

chmod 064 mismagius9
chmod 664 murkrow5

chmod 006 weezing1/snivy
chmod 737 weezing1/shellder
chmod 361 weezing1/hypno
chmod 004 weezing1/ursaring
chmod 551 weezing1

chmod 404 zweilous3/bronzor
chmod 317 zweilous3/prinplup
chmod 711 zweilous3/snorlax
chmod 733 zweilous3
chmod 570 mienfoo0

#ЗАДАНИЕ 3
#временная выдача прав
chmod -R 777 weezing1
chmod 777 hariyama4
chmod 777 mismagius9

cd weezing1
ln -s ../hariyama4 snivyhariyama
cd ..
cp -r weezing1 zweilous3/snorlax
cat weezing1/snivy weezing1/ursaring >> murkrow5_15
ln mismagius9 weezing1/ursaringmismagius
cp mismagius9 zweilous3/prinplup

rm weezing1/snivyhariyama
cp -f hariyama4 weezing1/snivyhariyama
ln -s weezing1 Copy_8

#возвращение прав на место
chmod 006 hariyama4
chmod 006 weezing1/snivy
chmod 737 weezing1/shellder
chmod 361 weezing1/hypno
chmod 004 weezing1/ursaring
chmod 551 weezing1
chmod 064 mismagius9

#ЗАДАНИЕ 4
mkdir tmp
wc -m murkrow5 1> ./tmp/messages 2> /dev/null
ls -lr mienfoo0 2>&1
grep -rHl ".*" ./*r sort 2> /dev/null
ls -lR 2>&1 ./*r | sort -k2n
ls -lR 2> ./tmp/messages ./*a | head -n2 | sort -nk2
grep -in "e$" mienfoo0/mightyena weezing1/snivy weezing1/ursaring 2> /dev/null


#Задание 5
rm hariyama4
rm zweilous3/bronzor
rm weezing1/snivyhariya*
rm weezing1/ursaringmismagi*
rmdir -p weezing1/
rmdir mienfoo0/nidoranF



