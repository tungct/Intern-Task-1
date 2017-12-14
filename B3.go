package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"sync"
	"sort"
)

type Pair struct {
	Key   string
	Value int
}

type PairList []Pair

var results chan map[string]int

func SearchAllFile(folder string)[]string{
	fs, err := ioutil.ReadDir(folder)
	var files []string
	if err != nil {
		log.Fatal(err)
		return []string{}
	}
	for _, f := range fs {
		files = append(files, f.Name())
	}
	return files
}

func worker(id int, jobs <-chan string, results chan<- map[string]int) {
	for j := range jobs {
		file := j
		words := ReadFileLine(file)
		dict := WordCount(words)
		results <- dict
	}
}

func readFile(file string){
	defer wg.Done()
	words := ReadFileLine(file)
	dict:= WordCount(words)
	results <- dict
	fmt.Println(dict)
}

func AppendMap(map1 map[string]int, map2 map[string]int) map[string]int{
	for k,v := range map2{
		map1[k] = map1[k] + v
	}
	m := map1
	return m
}

func InitPair(mp map[string]int) PairList{
	p := make(PairList, len(mp))
	i:= 0
	for k,v := range mp{
		p[i] = Pair{k,v}
		i++
	}
	return p
}

//implement method interface
func (p PairList) Len() int           { return len(p) }
func (p PairList) Swap(i, j int)      { p[i], p[j] = p[j], p[i] }
func (p PairList) Less(i, j int) bool { return p[i].Value < p[j].Value }

var wg sync.WaitGroup
func main() {
	folder := "input 3"
	files := SearchAllFile(folder)
	files = files
	results = make(chan map[string]int, 100)
	//jobs := make(chan string)
	//results := make(chan map[string]int, 100)
	//
	//for w := 1; w <= 7; w++ {
	//	go worker(w, jobs, results)
	//}
	for _, file := range files{
		wg.Add(1)
		file = folder + "/" + file
		go readFile(file)
	}

	//close(jobs)

	wg.Wait()
	all := make(map[string]int)
	ln := len(results)
	for i:=0;i<ln;i++{
		m := <- results
		all = AppendMap(all,m)
	}
	fmt.Println(all)
	pair := InitPair(all)
	sort.Sort(pair)
	fmt.Println("Top 10 Min : ")
	for i:=0;i<10;i++{
		fmt.Println(pair[i])
	}
	fmt.Println("Top 10 Max : ")
	for i:=len(pair)-1;i>len(pair)-11;i--{
		fmt.Println(pair[i])
	}

	//delete(all, "")
	//delete(all, " ")
	//outFile := "out.txt"
	//dictString := Map2String(all)
	//WriteFile(outFile, []byte(dictString))
	//fmt.Println("main finished")
}