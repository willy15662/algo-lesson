Your program will take a bunch of string arrays as input.
Please determine whether a given array comes from {0k1k | k ∈ Z+ }
( the input arrays do not contain empty string and non 0,1 characters)

找0跟1一樣多的字串
先過濾掉不是0開頭的，再過濾掉奇數字串，判斷左邊一半是否都為0，右邊一半都為1
