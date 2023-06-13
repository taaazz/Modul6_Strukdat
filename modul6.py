from collections import defaultdict

class Graph:
    def __init__(self):
        self.adjacencyList = defaultdict(list)

    def add_edge(self, source, destination):
        self.adjacencyList[source].append(destination)

    def DFS(self, startNode):
        visited = set()
        self.DFSUtil(startNode, visited)

    def DFSUtil(self, node, visited):
        visited.add(node)
        print(node, end=" ")

        neighbors = self.adjacencyList[node]
        for neighbor in neighbors:
            if neighbor not in visited:
                self.DFSUtil(neighbor, visited)

    def BFS(self, startNode):
        visited = set()
        queue = []
        visited.add(startNode)
        queue.append(startNode)

        while queue:
            node = queue.pop(0)
            print(node, end=" ")

            neighbors = self.adjacencyList[node]
            for neighbor in neighbors:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)

graph = Graph()

graph.add_edge('1', '2')
graph.add_edge('1', '4')
graph.add_edge('2', '5')
graph.add_edge('2', '1')
graph.add_edge('5', '2')
graph.add_edge('5', '3')
graph.add_edge('5', '9')
graph.add_edge('5', '7')
graph.add_edge('9', '5')
graph.add_edge('9', '8')
graph.add_edge('4', '6')
graph.add_edge('6', '7')
graph.add_edge('7', '6')
graph.add_edge('7', '11')
graph.add_edge('8', '9')
graph.add_edge('8', '11')
graph.add_edge('11', '7')
graph.add_edge('11', '10')

print("Hasil DFS (mulai dari simpul 1):")
graph.DFS('1')

print("\n\nHasil BFS (mulai dari simpul 1):")
graph.BFS('1')
