package main

import (
	"fmt"
	"strings"
	"io/ioutil"
	"strconv"
	"os"
	"log"
	"bufio"
)
var replacer = strings.NewReplacer("\t", " ", "\n"," ", "  ", " ")


func ReadFileLine(file string)(wor string){
	words := ""
	files, err := os.Open(file)
	if err != nil {
		log.Fatal(err)
	}
	defer files.Close()

	scanner := bufio.NewScanner(files)
	for scanner.Scan() {
		line := scanner.Text()
		if line != ""{
			if strings.Contains(line, "  "){
				line = replacer.Replace(line)
			}
			words += line + "\n"
			//line = strings.Replace(line, "\n", " ", -1)

		}else{

		}
	}

	if err := scanner.Err(); err != nil {
		log.Fatal(err)
	}
	return words

}

func RemoveItem(arr []string, item string) []string{
	for index,word := range arr{
		if word == item{
			return append(arr[:index], arr[(index+1):]...)
		}
	}
	return arr
}

func WriteFile(file string, arr []byte){
	err := ioutil.WriteFile(file, arr, 0644)
	fmt.Println(err)
}

func RemoveDuplicates(elements []string) []string {
	encountered := map[string]bool{}
	result := []string{}

	for v := range elements {
		if encountered[elements[v]] == true {
		} else {
			encountered[elements[v]] = true
			result = append(result, elements[v])
		}
	}
	return result
}

func WordCount(s string) (dict map[string]int) {
	str := replacer.Replace(s)
	words := strings.Split(str," ")
	//words = RemoveItem(words, "")
	words = RemoveItem(words," ")

	setWords := RemoveDuplicates(words)
	setWords = RemoveItem(setWords,"")
	setWords = RemoveItem(setWords," ")
	counts := make(map[string]int, len(words))
	for _, word := range words {
		counts[word]++
	}
	delete(counts, "")
	delete(counts, " ")
	return counts
}

func Map2String(words map[string]int) string{
	dictString := ""

	//for _, word := range setWords{
	//	line := word + " : " + strconv.Itoa(words[word]) + "\n"
	//	dictString += line
	//} )
	for k,v := range words{
		line := k + " : " + strconv.Itoa(v) + "\n"
		dictString +=line
	}
	return dictString
}


//func main() {
//	file := "01.txt"
//	words := ReadFileLine(file)
//	dict, setWords := WordCount(words)
//	outFile := "out.txt"
//	dictString := Map2String(dict, setWords)
//	WriteFile(outFile, []byte(dictString))
//	fmt.Println(dict[""])
//}
