javac Is13116371.java


COUNTER=0
COUNTER2=1
cd output
rm *.txt
cd files
rm *.txt
cd ..
cd ..

touch output/secondOutput.txt
str=`date`
diffFile=Diff_${str// /_}.txt
touch $diffFile
if [ "$#" -lt 3 ]; then
clear
   echo ""
	echo ""
	echo ""
	echo ""
	echo "                ****************************"
	echo "                *   testHarness 2016       *"
    echo "                *                          *"
	echo "                * Author: Benjamin Keil    *"
	echo "                *                          *"
	echo "                *  roguefendor@gmail.com   *"
	echo "                *                          *"
	echo "                ****************************"
	echo ""
	echo ""
    echo "[*] testHarness usage:"
    echo "[*]     ./testHarness  <file to write> <file to execute> number of iterations"
    echo "[*]     example: ./testHarnesstest.txt javaFile 100"
    echo "[*]     example: ./testHarnesstest.txt javaFile 1000"
    exit 1

fi

while [  $COUNTER -lt $3 ]; do
 	touch output/files/execution_$COUNTER.txt
 	touch output/files/original_$COUNTER.txt

 	java $2 > output/$1
    cat output/$1 > output/files/original_$COUNTER.txt
    while read -r line
		do
				echo "[*] iteration $COUNTER2"
		        echo "[*] exec process $COUNTER"
        if grep -q "$line" output/$1; then
	       let COUNTER2=COUNTER2+1 
	       echo "$line ">>output/files/execution_$COUNTER.txt
	    fi
	done < output/files/original_$COUNTER.txt
 echo "[*]  Diff out put: fileoriginal_$COUNTER.txt execution_$COUNTER.txt ">> $diffFile
 echo "[*]  Date: `date` " >> $diffFile 
 diff output/files/original_$COUNTER.txt output/files/execution_$COUNTER.txt >>$diffFile
 echo "">> $diffFile 
 echo "<----------------> " >> $diffFile 
 echo "" >> $diffFile 
 var=""
if [ -n "$5" ]; then
   echo "[*] <---------------->"
else
	echo "[*]  removing bloat "
    cd output/files
    rm *.txt
    cd ..
    cd ..
fi
 #rm output/execution_$COUNTER.txt
 let COUNTER2=COUNTER2+1 
 let COUNTER=COUNTER+1 
 echo $COUNTER
done	
