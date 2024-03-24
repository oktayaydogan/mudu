% Doğal dil girdisinin işlenmesi için kurallar
% Gelen cümleyi kelimelere ayırma
kelimelere_ayir(Cumle, Kelimeler) :-
    atomic_list_concat(Kelimeler, ' ', Cumle).

% Dilbilgisi analizi yapma
dilbilgisi_analizi(Kelimeler, Analiz) :-
    analiz_yap(Kelimeler, Analiz).

% Kelimelerin dilbilgisi analizi yapma
analiz_yap([], []).
analiz_yap([Kelime | Kalanlar], [AnalizKelime | AnalizKalanlar]) :-
    atom_length(Kelime, Uzunluk),
    (atom_chars(Kelime, [Karakter | _]) ->
        (char_type(Karakter, upper) ->
            HarfDurumu = 'Buyuk';
            HarfDurumu = 'Kucuk');
        HarfDurumu = 'Bilinmiyor'
    ),
    format(atom(AnalizKelime), 'Uzunluk:~w, HarfDurumu:~w', [Uzunluk, HarfDurumu]),
    analiz_yap(Kalanlar, AnalizKalanlar).

% Kullanıcının girdisini işleyen kural
islem :-
    write('Lütfen bir cümle girin: '), nl,
    read_line_to_string(user_input, Giris),
    kelimelere_ayir(Giris, Kelimeler),
    dilbilgisi_analizi(Kelimeler, Cevap),
    format('Cümlenin dilbilgisi analizi: ~w', [Cevap]).
