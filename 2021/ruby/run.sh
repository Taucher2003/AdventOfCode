day=$1

input="input/Day$day.txt"
rubyFile="Day$day.rb"

cat $input | ruby $rubyFile