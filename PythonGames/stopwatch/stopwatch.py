# template for "Stopwatch: The Game"
try:
    import simplegui
except:
	import SimpleGUICS2Pygame.simpleguics2pygame as simplegui

# define global variables
width = 300
height = 200
button_width = 100
position = [100,110]
position2 = [230,30]
time = 1
interval = 100
text = "0:00.0"
correct = 0
guess = 0


# define helper function format that converts time
# in tenths of seconds into formatted string A:BC.D
def format(t):
    A = t / 600
    t %= 600
    B = t / 100
    t %= 100
    C = t / 10
    D = t % 10
    return str(A)+":"+str(B)+str(C)+"."+str(D)
    
    
    
# define event handlers for buttons; "Start", "Stop", "Reset"
def start_button_handler():
    timer.start()
    
def stop_button_handler():
    global time
    global correct
    global guess
    if timer.is_running():
        timer.stop()
        if time % 10 == 0:
            guess += 1
            correct += 1
        else:
            guess += 1
                   
def reset_button_handler():
    global time
    global text
    global correct
    global guess
    if timer.is_running():
        timer.stop()
    time = 0
    text=format(time)
    correct =0
    guess =0
        

# define event handler for timer with 0.1 sec interval
def timer_handler():
    global time
    global text
    time += 1
    text = format(time)

# define draw handler
def draw_handler(canvas):
    canvas.draw_text(text, position, 36, 'Red')
    canvas.draw_text(str(correct)+"/"+str(guess), position2, 36, 'Red')
    
# create frame
frame = simplegui.create_frame("Stopwatch", width, height)

# register event handlers
frame.add_button('Start', start_button_handler,button_width)
frame.add_button('Stop', stop_button_handler,button_width)
frame.add_button('Reset', reset_button_handler,button_width)
frame.set_draw_handler(draw_handler)
timer = simplegui.create_timer(interval, timer_handler)

# start frame
frame.start()


# Please remember to review the grading rubric
