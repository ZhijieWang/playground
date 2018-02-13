package main

import (
	"container/list"
	"fmt"
)

func main() {
	//l := List{}
	//l.PushFront(&Element{"1", nil, nil})
	//fmt.Println(l.Head)
	cache := NewLRU(2)
	cache.Put("1", "1")
	cache.Put("2", "2")
	fmt.Println("Expected OutPut: 1")
	fmt.Println("Actual OutPut: ", cache.Get("1")) // returns 1

	cache.Put("3", "3") // evicts key 2
	fmt.Println("Expected OutPut: Not Found")
	fmt.Println("Actual OutPut: ", cache.Get("2")) // returns -1 (not found)
	cache.Put("4", "4")                            // evicts key 1
	fmt.Println("Expected OutPut: Not Found")
	fmt.Println("Actual OutPut: ", cache.Get("1")) // returns -1 (not           found)
	fmt.Println("Expected OutPut: 3")
	fmt.Println("Actual OutPut: ", cache.Get("3")) // returns 3
	fmt.Println("Expected OutPut: 4")
	fmt.Println("Actual OutPut: ", cache.Get("4")) // returns 4
}

// LRU is the cahce type, Leasr recent used cache
type LRU struct {
	size  int
	list  *list.List
	items map[interface{}]*list.Element
}

type entry struct {
	key   interface{}
	value interface{}
}

// NewLRU constructs a new LRU cache given a fixed depth
func NewLRU(size int) *LRU {
	return &LRU{
		size:  size,
		list:  list.New(),
		items: make(map[interface{}]*list.Element),
	}
}

// Put method inserts or updates the LRU cache with the key value pair. If the operation succeeds, return true, else false
func (l *LRU) Put(key, value interface{}) bool {
	// if item exists, update the value and Put it on the top of the stack
	if item, ok := l.items[key]; ok {
		l.list.MoveToFront(item)
		item.Value.(*entry).value = value
		return true
	}
	// if item does not exist, create a new entry, add it to the item list and map
	item := l.list.PushFront(&entry{key, value})
	l.items[key] = item
	// if it the stack runs over the max size, remove the oldes item
	if l.list.Len() > l.size {
		delete(l.items, l.list.Back().Value.(*entry).key)
		l.list.Remove(l.list.Back())
	}
	return true
}

// Get item given the key, if item if found, move the key to the top of the stack and return the value; if the key is not found, return nil
func (l *LRU) Get(key interface{}) interface{} {
	if item, ok := l.items[key]; ok {
		l.list.MoveToFront(item)
		return item.Value.(*entry).value
	}
	return nil
}
