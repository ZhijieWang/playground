package main

func main() {
	g := NewGraph()
	n := Node{}
	g.AddNode(&n)
	n1 := Node{}
	g.AddNode(&n1)
	g.AddEdge(&n, &n1, false)
}
