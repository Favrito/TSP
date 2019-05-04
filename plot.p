set xlabel "X"
set ylabel "y"
plot "solution/nodes" using 2:3 title "Nodes" with points pointtype 6, "solution/nodes" using 2:3 title "Tour" with lines lc "red" lw 2