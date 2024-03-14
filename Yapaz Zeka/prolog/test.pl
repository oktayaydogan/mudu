
type(X, Y) :-
	color(X, Color), 
	color(Y, Color).

color(apple, red).
color(banana, yellow).
color(lemon, yellow).
color(cherry, red).
color(strawberry, red).
color(blueberry, blue).

test1 :-
	(
		type(apple, cherry)
		 ->
				write('Test 1 passed'), nl;
		write('Test 1 failed'), nl).

test2 :-
	(
		type(cherry, strawberry)
		 ->
				write('Test 2 passed'), nl;
		write('Test 2 failed'), nl).

test3 :-
	(
		type(strawberry, blueberry)
		 ->
				write('Test 3 passed'), nl;
		write('Test 3 failed'), nl).

test4 :-
	(
		type(lemon, blueberry)
		 ->
				write('Test 3 failed'), nl;
		write('Test 3 passed'), nl).

run_tests:-
	test1, test2, test3, test4.