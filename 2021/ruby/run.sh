day=$1

input="input/day_$day.txt"
rubyFile="day_$day.rb"

time (cat $input | ruby $rubyFile)