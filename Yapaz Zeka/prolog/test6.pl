% Operators
:- op(500, xfx, v).
:- op(500, xfx, &).
:- op(500, xfx, ->).
:- op(500, xfx, <->).
:- op(500, fx, -).


s('a dog is running', p).
s('a cat is walking', q).
s('a mouse is hiding', r).
s('a bird is singing', p20).
s('a dog runs', p).
s('a cat walks', q).
s('a mouse hides', r).

s(String, -For):-
    concat('it is not the case that', String1, String), s(String1, For).
    