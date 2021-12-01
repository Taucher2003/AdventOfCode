using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdventOfCode {
    class Program {
        static void Main(string[] args) {
            //I know, the path says Java, but I don't care as this file is also part of advent of code
            using (StreamReader sr = new StreamReader(@"D:\_Daten\Development\Java\intellij-workspace\advent-of-code\src\main\\resources\_2020\input3.txt")) {
                String input = sr.ReadToEnd();
                //Task 1
                int right = -3;
                int trees = 0;
                foreach(String entry in input.Replace("\r", "").Split('\n')) {
                    if (entry.Length == 0)
                        continue;
                    int pos = (right + 3) % entry.Length;
                    char currentPos = entry.Substring(pos, 1).ToCharArray()[0];
                    if(currentPos == '#') {
                        trees++;
                    }
                    right += 3;
                }
                Console.WriteLine(trees + "");
                //Task 2
                int result = 1;
                result *= getTrees(1, 1);
                result *= getTrees(3, 1);
                result *= getTrees(5, 1);
                result *= getTrees(7, 1);
                result *= getTrees(1, 2);
                Console.WriteLine(result + "");
                Console.ReadKey();
            }
        }

        static int getTrees(int right, int down) {
            int trees = 0;
            //I know, the path says Java, but I don't care as this file is also part of advent of code
            using (StreamReader sr = new StreamReader(@"D:\_Daten\Development\Java\intellij-workspace\advent-of-code\src\main\\resources\_2020\input3.txt")) {
                String input = sr.ReadToEnd();
                int posRight = 0 - right;
                int line = 0;
                foreach (String entry in input.Replace("\r", "").Split('\n')) {
                    if (entry.Length == 0)
                        continue;
                    if(line % down == 0) {
                        int pos = (posRight + right) % entry.Length;
                        char currentPos = entry.Substring(pos, 1).ToCharArray()[0];
                        if (currentPos == '#') {
                            trees++;
                        }
                        posRight += right;
                    }
                    line++;
                }
            }
            return trees;
        }
    }
}
