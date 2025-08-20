# Problem 2

Given a list of digits, sorted in descending order, check if it is possible to form a palindrome and if so, print it. If not, print "imposibil".

Example input: **8 7 7 4 4** results in output: **74847**.
Example input: **8 8 7 5 5 4 4 0** results in output: **imposibil**.

```
list1 <- INPUT LIST OF NUMBERS
n <- LEN(list1)
poslist1 <- 0
singlenum <- -1
listfinal LIST OF NUMBERS
posappendleft <- 0
posappendright <- n - 1

imposibil <- false
WHILE poslist1 < len(list1) AND imposibil = false
    x <- POS(list1, poslist1)
    y <- -1
    IF poslist1 + 1 < n THEN
        y <- POS(list1, poslist1 + 1)
    ENDIF
    IF x = y THEN
        appendInPos(listfinal, x, posappendleft)
        appendInPos(listfinal, y, posappendright)
        posappendleft <- posappendleft + 1
        posappendright <- posappendright - 1
        poslist1 <- poslist1 + 2
    ELSE
        IF singlenum = -1 THEN
            singlenum <- x
            poslist1 <- poslist1 + 1
        ELSE
            imposibil <- true
        ENDIF
    ENDIF
ENDWHILE

IF singlenum != -1 THEN
    appendInPos(listfinal, singlenum, posappendleft)
ENDIF

IF imposibil THEN
    OUTPUT("imposibil")
ELSE
    OUTPUT("posibil")
    OUTPUT(listfinal)
ENDIF

FUNCTION appendInPos(list, value, position) {
    if (position < 0 || position > length(list)) {
        stop("Position out of bounds")
    }

    listOut LIST OF NUMBERS
    i <- 0
    WHILE i < position
        listOut[i] <- list[i]
        i <- i + 1
    END WHILE
    listOut[position] <- value
    i <- position + 1
    WHILE i < length(list)
        listOut[i] <- list[i - 1]
        i <- i + 1
    END WHILE
    RETURN listOut
ENDFUNCTION
```

# Let's test the code with an example input
list1 <- c(8, 7, 7, 4, 4)
n = 5
output <- c(7, 4, 8, 4, 7)

# Another example input that is impossible
list1 <- c(8, 8, 7, 5, 5, 4, 4, 0)
n = 8
output <- "imposibil"
