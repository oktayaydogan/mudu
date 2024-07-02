terminate = False

while not terminate:
    #get month and year
    ay = int(input('1-12 arasında bir ay giriniz(çıkmak için -1):'))

    if ay == -1:
        terminate = True
    else:
        while ay < 1 or ay > 12:
            ay = int(input('Geçersiz giriş - 1-12 arasında bir ay giriniz:'))

        yil = int(input('Yıl giriniz (yyyy):'))
        #print(yıl)

        while yil < 1800 or yil > 2099:
            yil = input('Geçersiz - (1800 ile 2099 arasında bir yıl giriniz:')

        #artık yıl mı?
        if (yil % 4 == 0) and (not (yil % 100 == 0) or (yil % 400 == 0)):
            artik_yil = True
        else:
            artik_yil = False

        #haftanın günü

        yy_basamak = yil // 100
        yil_basamak= yil % 100

        deger = yil_basamak + (yil_basamak // 4)

        if yy_basamak == 18:
            deger = deger + 2
        elif yy_basamak == 20:
            deger = deger + 6

    #artık_yıl=str(artık_yıl)
    #print('artık yıl:'+' '+artık_yıl)

    #ay içindeki gün sayıları
    if ay in (1, 3, 5, 7, 8, 10, 12):
        ay_gun = 31
    elif ay in (4, 6, 9, 11):
        ay_gun = 30
    elif artik_yil:
        ay_gun = 29
    else:
        ay_gun=28

    ay_str=str(ay)
    yil_str=str(yil)
    ay_gun_str=str(ay_gun)
    print(ay_str+ ' '+yil_str+' '+ay_gun_str+' '+'gündür' )

    if artik_yil:
        print(yil_str+' '+'artık yıldır')
    else:
        print(yil_str+' '+'artık yıl değildir')



    if ay == 1  and not artik_yil:
        deger = deger + 1
    elif ay == 2:
        if artik_yil:
            deger =deger + 3
        else:
            deger = deger + 4
    elif ay == 3 or ay == 11:
        deger = deger + 4
    elif ay == 5:
        deger = deger + 2
    elif ay == 6:
        deger = deger + 5
    elif ay == 8:
        deger = deger + 8
    elif ay == 9 or ay == 12:
        deger = deger + 6
    elif ay == 10:
        deger = deger + 1

    hafta_gun = (deger + 1) % 7 # 1-Pazar, 2-Pazartesi,...

    hafta_gun_str = str(hafta_gun)

    print('haftanın '+hafta_gun_str+'. günü')

    if ay == 1:
        ay_isim = 'Ocak'
    elif ay == 2:
        ay_isim = 'Şubat'
    elif ay == 3:
        ay_isim='Mart'
    else:
        ay_isim = 'Aralık'

    ay_isim_str = str(ay_isim)

    print(ay_isim_str+' '+yil_str)

    if hafta_gun == 0:
        baslangic_kolon = 7
    else:
        baslangic_kolon = hafta_gun

    kolon = 1
    kolon_genislik = 4
    bosluk_krktr = ' '
    bosluk_kolon = format(bosluk_krktr, str(kolon_genislik))

    while kolon <= baslangic_kolon:
        print(bosluk_kolon, end=' ')
        kolon = kolon + 1

    b_gun = 1

    while b_gun <= ay_gun:
        if b_gun < 10:
             print(format(bosluk_krktr, '3')+str(b_gun), end=' ')
        else:
            print(format(bosluk_krktr, '2')+str(b_gun), end=' ')

        if kolon < 7:
            kolon = kolon + 1
        else:
            kolon = 1
            print()

        b_gun = b_gun + 1

    print('\n')












