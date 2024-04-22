% Olgular
kadin(fatma).
kadin(ayse).
kadin(suna).
kadin(oya).
kadin(leyla). % örneğin, yeni bir kişi

erkek(mehmet).
erkek(ahmet).
erkek(can).
erkek(ege).
erkek(kaya).
erkek(ali). % örneğin, yeni bir kişi

anne(fatma, oya).
anne(ayse, kaya).
anne(oya, can).
anne(oya, ege).
anne(suna, ali). % örneğin, yeni bir ilişki

baba(ahmet, oya).
baba(ahmet, suna).
baba(mehmet, kaya).
baba(kaya, can).
baba(kaya, ege).
baba(ali, leyla). % örneğin, yeni bir ilişki

% Kurallar
insan(X) :- kadin(X); erkek(X).
ebeveyn(X, Y) :- anne(X, Y); baba(X, Y).
ata(X, Y) :- ebeveyn(X, Z), ata(Z, Y).
kardes(X, Y) :- ebeveyn(Z, X), ebeveyn(Z, Y), X \= Y.
amca(X, Y) :- erkek(X), kardes(X, Z), ebeveyn(Z, Y).
teyze(X, Y) :- kadin(X), kardes(X, Z), ebeveyn(Z, Y).
hala(X, Y) :- kadin(X), (teyze(X, Y); amca(X, Y)).
dayi(X, Y) :- erkek(X), (amca(X, Y); teyze(Y, Z), ebeveyn(X, Z)).
eniste(X, Y) :- erkek(X), (hala(Y, Z), ebeveyn(X, Z); teyze(Y, Z), ebeveyn(X, Z)).
yegen(X, Y) :- insan(X), (amca(Y, X); teyze(Y, X)).
kuzen(X, Y) :- insan(X), ebeveyn(Z, X), ebeveyn(T, Y), kardes(Z, T).

akrabalar(X, Y) :- ata(X, Y).
akrabalar(X, Y) :- ata(Y, X).
akrabalar(X, Y) :- ebeveyn(Z, X), akrabalar(Z, Y).
akrabalar(X, Y) :- ebeveyn(Z, Y), akrabalar(Z, X).
akrabalar(X, Y) :- kardes(X, Y).
akrabalar(X, Y) :- amca(X, Y).
akrabalar(X, Y) :- teyze(X, Y).
akrabalar(X, Y) :- hala(X, Y).
akrabalar(X, Y) :- dayi(X, Y).
akrabalar(X, Y) :- eniste(X, Y).
akrabalar(X, Y) :- yegen(X, Y).
akrabalar(X, Y) :- kuzen(X, Y).
