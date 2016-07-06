library(grid)

heart <- function(lcolor){
  t=seq(0, 2*pi, by=0.1)
  x=16*sin(t)^3
  y=13*cos(t)-5*cos(2*t)-2*cos(3*t)-cos(4*t)
  a=(x-min(x))/(max(x)-min(x))
  b=(y-min(y))/(max(y)-min(y))
  grid.lines(a,b,gp=gpar(col=lcolor,lty = "solid",lwd = 6))
}

heart("hotpink")

grid.newpage()

rose=function(){
  grid.circle(x=0.5, y=0.5, r=0.5,gp=gpar(fill="red",lwd = 3))
  vp <- viewport(.5, .5, w=.9, h=.9)
  pushViewport(vp)
  grid.polygon(x=c(0.08, .5, 0.94),y=c(.22, 1.03, .22), gp=gpar(lwd =3))
  vp2 <- viewport(.5, .5, w=.4, h=.4)
  pushViewport(vp2)
  grid.circle(x=0.5, y=0.5, r=0.5,gp=gpar(fill="red",lwd = 3))
  vp3 <- viewport(.5, .5, w=.9, h=.9,angle=180)
  pushViewport(vp3)
  grid.polygon(x=c(0.08, .5, 0.94),y=c(.22, 1.03, .22),gp=gpar(lwd = 3))
}

rose()

grid.newpage()
pushViewport(viewport(x=0.1, y=0.1,w=0.2, h=0.2))
grid.newpage()
for (j in 1:30) {
  vp <- viewport(.5, .5, w=.9, h=.9)
  pushViewport(vp)
  heart("hotpink")
}

grid.newpage()
vp1 <- viewport(.4, .5, w=.5, h=.5,angle=15)
pushViewport(vp1)
heart("red")
vp2 <- viewport(0.9, .27, w=.7, h=.7,angle=-30)
pushViewport(vp2)
heart("hotpink")
grid.text("Love you forever",
          x=0.2,y =1.2, just = c("center", "bottom"),
          gp = gpar(fontsize=20), vp = vp)

vp3 <- viewport(-0.65, 1.2, w=.3, h=.3,angle=-30)
pushViewport(vp3)
rose()
