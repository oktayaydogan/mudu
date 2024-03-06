% A knowledge base describing the father-child relationship
father(adam, john).
father(adam, sara).
father(james, adam).

% A knowledge base describing the mother-child relationship
mom(eve, john).
mom(eve, sara).
mom(lisa, adam).

% Rule that checks whether a person is a mother or father
parent(X, Y) :- father(X, Y).
parent(X, Y) :- mom(X, Y).

% Rule that checks whether a person is a grandfather or grandmother
grandfather(X, Z) :- father(X, Y), parent(Y, Z).
grandma(X, Z) :- mom(X, Y), parent(Y, Z).