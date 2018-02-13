package main

import (
	"fmt"
)

func main() {
	//l := List{}
	//l.PushFront(&Element{"1", nil, nil})
	//fmt.Println(l.Head)
	cache := NewLRU(2)
	cache.PrintLRU()
	cache.put("1", "1")
	cache.PrintLRU()
	cache.put("2", "2")
	cache.PrintLRU()
	fmt.Println("Expected Output: 1")
	fmt.Println("Actual Output: ", cache.get("1")) // returns 1

	cache.put("3", "3") // evicts key 2
	cache.PrintLRU()
	fmt.Println("Expected Output: Not Found")
	fmt.Println("Actual Output: ", cache.get("2")) // returns -1 (not found)
	cache.put("4", "4")                            // evicts key 1
	fmt.Println("Expected Output: Not Found")
	fmt.Println("Actual Output: ", cache.get("1")) // returns -1 (not           found)
	fmt.Println("Expected Output: 3")
	fmt.Println("Actual Output: ", cache.get("3")) // returns 3
	fmt.Println("Expected Output: 4")
	fmt.Println("Actual Output: ", cache.get("4")) // returns 4
}

// Element type is container for linked list implementation
type Element struct {
	Key    string
	Value  string
	before *Element
	after  *Element
}

// List type is linked list implementation
type List struct {
	Head *Element
	Tail *Element
	Len  int
}

// Remove ...
func (l *List) Remove(e *Element) bool {
	if e.before != nil {
		if e.after != nil {
			e.after.before = e.before
		}
		e.before.after = e.after
	} else {
		if e.after != nil {
			e.after.before = e.before
		}
	}
	if l.Tail == e {
		l.Tail = e.before
	}
	e.before = nil
	e.after = nil
	l.Len--
	return true
}

// PushFront ...
func (l *List) PushFront(e *Element) bool {
	if (e.before != nil) || (e.after != nil) {
		l.Remove(e)
	}
	if l.Head != nil {
		l.Head.before = e
		e.after = l.Head
	}
	l.Head = e
	l.Len++
	if l.Tail == nil {
		l.Tail = e
	}
	return true
}

// LRU ..
type LRU struct {
	maxDepth int
	storage  *List
	keys     map[string]*Element
}

// maintain the stack depth and value depth
//
func (l *LRU) put(key string, value string) {
	if val, ok := l.keys[key]; ok {
		val.Value = value
		return
	}

	if l.storage.Len == l.maxDepth {
		delete(l.keys, l.storage.Tail.Key)
		l.storage.Remove(l.storage.Tail)
	}
	l.storage.PushFront(&Element{key, value, nil, nil})
	l.keys[key] = l.storage.Head
}

func (l *LRU) get(key string) string {
	if val, ok := l.keys[key]; ok {
		l.storage.PushFront(val)
		return val.Value

	}
	return "Not Found"

}

// NewLRU constructor
func NewLRU(depth int) LRU {
	var lru = LRU{depth, &List{}, make(map[string]*Element)}
	return lru
}

// PrintLRU is a utility function to debug LRU
func (l LRU) PrintLRU() {
	start := l.storage.Head
	fmt.Println("Current List")
	fmt.Println("Head is ", l.storage.Head)
	fmt.Println("Tail is ", l.storage.Tail)
	for start != nil {
		fmt.Println(start)
		start = start.after
	}
}
