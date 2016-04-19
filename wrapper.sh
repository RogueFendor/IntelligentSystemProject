CTR1=0

while [ $CTR1 -lt $1 ]; do


  ./testHarness.sh test.txt Is13116371 100 y

let CTR1=CTR1+1

done