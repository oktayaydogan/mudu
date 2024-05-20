% Doğal sayılar
dogal_sayi(0).
dogal_sayi(N):- N > 0, M is N-1, dogal_sayi(M).

% Toplama işlemi
topla(N,0,N):- dogal_sayi(N).
topla(N,M,S):- dogal_sayi(N),
                dogal_sayi(M),
                T is M-1, topla(N, T, R), S is R+1.

% Çarpma işlemi
carpma(N,0,0):- dogal_sayi(N).
carpma(N,M,S):- dogal_sayi(N),
                dogal_sayi(M),
                T is M-1, carpma(N, T, R), S is R+N.

% Üs alma işlemi
us(N,0,1):- dogal_sayi(N).
us(N,M,S):- dogal_sayi(N),
            dogal_sayi(M),
            T is M-1, us(N, T, R), S is R*N.           

% Hanoi kuleleri
hanoi(1, A, _, C) :- writeln(A), write(' -> '), write(C), nl.
hanoi(N, A, B, C) :- M is N-1, hanoi(M, A, C, B), hanoi(1, A, B, C), hanoi(M, B, A, C).










