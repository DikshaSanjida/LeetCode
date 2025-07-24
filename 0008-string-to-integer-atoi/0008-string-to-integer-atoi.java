class Solution {
    public int myAtoi(String s) {

        int index=0,sign=1,total=0;
        int length=s.length();

        while(index<length && s.charAt(index)==' '){
            index++;
        }
        if(index < length){
            char signChar = s.charAt(index);
            if (signChar == '-') {
                sign = -1;  // Sign is negative
                index++;
            } else if (signChar == '+') {
                index++;  // Just skip the '+' sign
            }
        }

        // Step 3: Convert numbers and avoid overflow
        while (index < length) {
            char currentChar = s.charAt(index);
            // Break if current character is not a digit
            if (currentChar < '0' || currentChar > '9') {
                break;
            }

            // Convert char to digit
            int digit = currentChar - '0';

            // Check for overflow and clamp if necessary
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;  // Update total
            index++;
        }

        return total * sign;
        }
        
    }
