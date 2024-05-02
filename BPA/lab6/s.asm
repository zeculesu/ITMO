ORG 0x000
V0: 	WORD $default, 0x180
V1: 	WORD $int1, 0x180
V2: 	WORD $int2, 0x180
V3: 	WORD $default, 0x180
V4: 	WORD $default, 0x180
V5: 	WORD $default, 0x180
V6: 	WORD $default, 0x180
V7: 	WORD $default, 0x180

ORG 0x01B
x: WORD 0
min: 	WORD 0xFFE7 ; -25
max: 	WORD 0x0015 ; 25

default: IRET 

start:
	DI
	CLA
	OUT 0x1 ;запрет на прерывания неиспользуемых кву
	OUT 0x7
	OUT 0xB
	OUT 0xE
	OUT 0x12
	OUT 0x16
	OUT 0x1A
	OUT 0x1E

	LD #0x9 ;задаем векторы для ву1 и ву2
	OUT 0x3
	LD #0xA
	OUT 0x5
	EI

main:
	DI
	LD x
	INC
	CALL check
	ST x
	EI
	JUMP main
	
int1:
	DI
	LD x
	NOP 	; отладка
	ASL
	ASL
	ADD x
	OUT 0x2
	NOP 	; отладка
	EI
	IRET

int2:
	DI
 	IN 0x4
 	NOP  ; отладка
	NEG
	CALL check
	ST x
	NOP  ; отладка
	EI
	IRET

check:
	CMP min
	BLT setmin
	CMP max
	BGE setmin
	JUMP return

setmin: LD min
return: RET
	