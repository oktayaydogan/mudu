% Olgular
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

% Kurallar
insan(X) :- kadın(X).
insan(X) :- erkek(X).

ebeveyn(X, Y) :- anne(X, Y).
ebeveyn(X, Y) :- baba(X, Y).

kardes(X, Y) :- ebeveyn(Z, X), ebeveyn(Z, Y), not(X = Y).

teyze(X, Y) :- kadın(X), anne(Z, Y), kardes(X, Z).

babaanne(X, Y) :- anne(X, Z), baba(Z, Y).

anneanne(X, Y) :- anne(X, Z), anne(Z, Y).

buyukbaba(X, Y) :- baba(X, Z), ebeveyn(Z, Y).