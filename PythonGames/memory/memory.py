# implementation of card game - Memory

try:
    import simplegui
except:
	import SimpleGUICS2Pygame.simpleguics2pygame as simplegui

import random

state = 0      # 0 1 2 number of exposed cards in one step
font_size = 30
font_color = "White"
card_width = 50
card_length = 100
canvas_width = 800
canvas_height = 100
cards = []     # eight pairs 0-7
position = []
exposed=[]
first = 0      # first exposed card index
second = 0     # second exposed card index
steps=0        # steps used

# helper function to initialize globals
def new_game():
    global state, cards, position, exposed,steps
    state = 0
    steps=0
    position = [0]
    exposed=[False]
    cards = range(8)
    cards.extend(range(8))
    random.shuffle(cards)
    for i in range(1,16):
        position.append(i * canvas_width // 16 - 1)
        exposed.append(False)

# define event handlers
def mouseclick(pos):
    global state, first, second, steps     
    if state == 0:
        for i in range(15):
             if pos[0] > position[15]:
                first = 15
                break
             elif position[i] < pos[0] < position[i+1]:
                first = i
                break      
        if exposed[first] == False:
            # print first
            exposed[first] = True
            state = 1
            steps += 1
    elif state == 1:
        for i in range(15):
             if pos[0] > position[15]:
                second = 15
                break
             elif position[i] < pos[0] < position[i+1]:
                second = i
                break
        if exposed[second] == False:
            # print second
            exposed[second] = True
            state = 2
    else:
        f=first
        s=second
        for i in range(15):
             if pos[0] > position[15]:
                first = 15
                break
             elif position[i] < pos[0] < position[i+1]:
                first = i
                break
        if exposed[first] == False:
            # print first
            exposed[first] = True
            state = 1
            steps += 1
            if cards[f] != cards[s]:
                exposed[f] = False
                exposed[s] = False 

# cards are logically 50x100 pixels in size    
def draw(canvas):
    # draw number or rectangle
    for i in range(16):
        if exposed[i]==True:
            canvas.draw_text(str(cards[i]), [position[i]+card_width * 0.4,card_length * 0.55],font_size, font_color);
        else:
            canvas.draw_line([position[i]+card_width//2, 0], [position[i]+card_width//2, canvas_height], card_width-1, 'Green')
            canvas.draw_line([position[i]+1, 0], [position[i]+1, canvas_height], 1, 'Gold')
            canvas.draw_line([canvas_width-1, 0], [canvas_width-1, canvas_height], 1, 'Gold')
    label.set_text('Turns = ' + str(steps))

# create frame and add a button and labels
frame = simplegui.create_frame("Memory", canvas_width, canvas_height)
frame.add_button("Reset", new_game)
label = frame.add_label("Turns = 0")

# register event handlers
frame.set_mouseclick_handler(mouseclick)
frame.set_draw_handler(draw)

# get things rolling
new_game()
frame.start()
