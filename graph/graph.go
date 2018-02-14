package main

// Graph data structure to hold value
type Graph struct {
	nodes []Node
	edges []Edge
}

// Node data structure
type Node struct {
	id    int
	label int
	edges []*Edge
}

// Edge data structure
type Edge struct {
	id       int
	lable    int
	directed bool
	fromNode *Node
	toNode   *Node
}

// NewGraph constructor
func NewGraph() *Graph {
	return &Graph{
		nodes: make([]Node, 0),
		edges: make([]Edge, 0),
	}
}
