
def find_winner(competitions: list, results: list):

    score_board = {}

    count = 0
    for competitors in competitions:

        winner_index = 1 if results[count] == 0 else 0

        winner = competitors[winner_index]

        if winner in score_board:
            score = score_board[winner]
            score += 3
            score_board[winner] = score
        else:
            score_board[winner] = 3

        count += 1
    
    # find highest score
    winner = {'name':'','score':0}

    for competitor in score_board:

        print("competitor:{}, score={}".format(competitor,score_board[competitor]))

        if score_board[competitor] > winner["score"]:
            winner["score"] = score_board[competitor]
            winner["name"] = competitor

    return winner['name']

winner = find_winner([["HTML", "C#"], ["C#", "Python"], ["Python", "HTML"]],[0, 0, 1])
print("winner:{}".format(winner))
