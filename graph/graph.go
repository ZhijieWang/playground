package main

// Graph data structure to hold value
type Graph struct {
	nodes   []*Node
	edges   []*Edge
	counter int
}

// Node data structure
type Node struct {
	label int
	edges []*Edge
}

// Edge data structure
type Edge struct {
	label    int
	directed bool
	fromNode *Node
	toNode   *Node
}

// NewGraph constructor
func NewGraph() *Graph {
	return &Graph{
		nodes:   make([]*Node, 0),
		edges:   make([]*Edge, 0),
		counter: 0,
	}
}

// AddNode add a constructed node into the graph
func (g *Graph) AddNode(n *Node) {
	g.nodes = append(g.nodes, n)
	g.counter++
}

// AddEdge create an edge given the from node and to node, and direction flag. If direction flag is set to true, then the edge will be Node 1 -> Node 2, else it will ignore direction
func (g *Graph) AddEdge(from *Node, to *Node, directed bool) {
	e := &Edge{label: 0, directed: directed, fromNode: from, toNode: to}
	g.edges = append(g.edges, e)
	from.edges = append(from.edges, e)
	to.edges = append(to.edges, e)
	g.counter++
}
