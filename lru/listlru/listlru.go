package main

import (
	"container/list"
)

type LRU struct {
	size  int
	list  *list.List
	items map[interface{}]*list.Element
}

type entry struct {
	key   interface{}
	value interface{}
}

func NewLRU(size int) *LRU {
	return &LRU{
		size:  size,
		list:  list.New(),
		items: make(map[interface{}]*list.Element),
	}
}
