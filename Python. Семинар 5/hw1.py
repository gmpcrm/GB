import random

max_candy = 2021
max_candy_per_turn = 28
first_turn = True

def player_turn(title, prev_count = 0):
    global first_turn
    first_turn = False
    count = 0
    max_count = max_candy_per_turn if max_candy_per_turn < max_candy else max_candy
    while count < 1 or count > max_candy or count > max_candy_per_turn:
        count = int(input(f"{title}: Сколько возьмете конфет (максимум {max_count})?"))
    return count

def bot_turn(title, prev_count = 0):
    global first_turn
    first_turn = False
    max_count = max_candy_per_turn if max_candy_per_turn < max_candy else max_candy
    count = max_count if max_count == 1 else random.randrange(1, max_count)
    print(f"{title}: Я взял {count} конфет(ы)!")
    return count

def smart_bot_turn(title, prev_count = 0):
    global first_turn
    if first_turn:
        count = max_candy % (max_candy_per_turn + 1)
        first_turn = False
    else:
        count = max_candy if max_candy <= max_candy_per_turn else max_candy_per_turn - prev_count + 1
    print(f"{title}: Я взял {count} конфет(ы)!")
    return count

all_players = [
[("Игрок 1", player_turn), ("Игрок 2", player_turn)], 
[("Человек", player_turn), ("Бот", bot_turn)],
[("Человек", player_turn), ("Смарт", smart_bot_turn)],
[("Бот 1", bot_turn), ("Бот 2", bot_turn)],
[("Бот", bot_turn), ("Смарт", smart_bot_turn)],
[("Смарт 1", smart_bot_turn), ("Смарт 2", smart_bot_turn)]
]

mode = 0
while mode < 1 or mode > 6:
    print("Введите режим игры:")
    print("1: Человек-человек")
    print("2: Человек-бот")
    print("3: Человек-смартбот")
    print("4: Бот-бот")
    print("5: Бот-смартбот")
    print("6: Смартбот-смартбот")
    mode = int(input())

players = all_players[mode - 1]

if random.randint(0,2):
    players[0],players[1] = players[1],players[0]

count = 0
print(players[0][0] + " играет первым!")
while max_candy > 0:
    for player in players:
        count = player[1](player[0], count)
        max_candy -= count
        if max_candy:
            print(f"Осталось {max_candy} конфет(ы)")
        else:
            print("Конфет не осталось! " + player[0] + " выиграл!")
            break

