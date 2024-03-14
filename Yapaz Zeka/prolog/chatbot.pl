% Veritabanı
soru_cevap('merhaba', ['Merhaba!', 'Selam!', 'Nasılsınız?']).
soru_cevap('nasılsın', ['İyiyim, teşekkür ederim!', 'Teşekkürler, siz nasılsınız?']).
soru_cevap('selam', ['Merhaba!', 'Nasılsınız?', 'Hoşgeldiniz!']).
soru_cevap('güle güle', ['Görüşmek üzere!', 'Hoşça kal!', 'Güle güle!']).
soru_cevap('ne yapıyorsun', ['Kullanıcılarla konuşuyorum!', 'Bir chatbot olmaya çalışıyorum!', 'Soruları yanıtlamaya çalışıyorum!']).
soru_cevap('kaç yaşındasın', ['Aslında yaşım yok, ben bir programım!', 'Benim için yaş pek bir anlam ifade etmiyor!']).
soru_cevap('seni kim yarattı', ['Beni OpenAI tarafından geliştirildi!', 'Beni insanlar tarafından programlandı!', 'Ben bir yapay zekayım ve gelişimi sürekli devam ediyor!']).
soru_cevap('senin adın ne', ['Benim adım ChatProlog!', 'İsmim Chatbot!', 'Beni ChatProlog olarak çağırabilirsiniz!']).

% Genel konular
soru_cevap('hava nasıl', ['Hava durumu hakkında bilgi veremem, bir hava durumu servisi kullanabilirsiniz.', 'Hava durumu hakkında bilgi almak için bir hava durumu uygulaması kullanabilirsiniz.']).
soru_cevap('saat kaç', ['Şu anda saat %T saatine göre.']) :- get_time(Timestamp), stamp_date_time(Timestamp, DateTime, local), format_time(atom(Time), '%T', DateTime).

% Eğlence
soru_cevap('bir şaka anlat', ['Neden bir maymun ağacın üstüne tırmanır? Çünkü ağaç diğer tarafı daha yüksektir!', 'Neden bir tavuk yolun karşısına geçer? İyi bir nedeni yoktur, sadece karşıya geçer!']).
soru_cevap('favori film nedir', ['Ben bir chatbot olduğum için favori filmim yok! Sizin favori filminiz nedir?']).
soru_cevap('favori kitap nedir', ['Ben bir yapay zeka olduğum için kitap okuyamam ama insanlar genellikle "1984" veya "Dune" gibi kitapları seviyorlar.']).

% Bilgi
soru_cevap('dünya nüfusu', ['2022 itibariyle dünya nüfusu yaklaşık 7.9 milyar olarak tahmin ediliyor.']).
soru_cevap('en büyük ülke', ['Yüzölçümü bakımından en büyük ülke Rusya Federasyonu, nüfus bakımından ise Çin Halk Cumhuriyeti en büyük ülkedir.']).

% Spor
soru_cevap('en popüler spor', ['Futbol dünya genelinde en popüler spordur.']).
soru_cevap('favori spor takımı', ['Ben bir chatbot olduğum için favori bir spor takımım yok ama insanlar genellikle futbol, basketbol veya ​​futbol takımlarını destekler.']).

% Sağlık
soru_cevap('sağlıklı yaşam', ['Sağlıklı yaşam için dengeli beslenme, düzenli egzersiz yapma ve yeterli uyku önemlidir.']).
soru_cevap('stresle başa çıkma', ['Stresle başa çıkmak için meditasyon, derin nefes almak ve stres yönetimi tekniklerini uygulamak faydalı olabilir.']).

soru_cevap(_, ['Üzgünüm, sizi anlayamadım.']).

% Cevap üretme
cevapla :-
    write('Soru: '),
    read(Soru),
    cevap_ver(Soru, Cevap),
    write('Cevap: '), write(Cevap), nl,
    cevapla.

% Soruya cevap verme
cevap_ver(Soru, Cevap) :-
    soru(Soru, CevapListesi),
    random_member(Cevap, CevapListesi).

% Main
:- initialization(cevapla).