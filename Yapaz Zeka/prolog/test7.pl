
kadın(fatma).
kadın(ayşe).
kadın(suna).
kadın(oya).

erkek(mehmet).
erkek(ahmet).
erkek(can).
erkek(ege).
erkek(kaya).

anne(fatma, oya).
anne(ayşe, kaya).
anne(oya, can).
anne(oya, ege).

baba(ahmet, oya).
baba(ahmet, suna).
baba(mehmet, kaya).
baba(kaya, can).
baba(kaya, ege).

ebeveyn(X, Y) :- anne(X, Y).
ebeveyn(X, Y) :- baba(X, Y).

ata(X, Y) :- ebeveyn(X, Z), ata(Z, Y).
