"""
# Definition for a Node."""

class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        if not node:
            return node

        visited = {}
        stack = []
        stack.append(node)
        visited[node] = Node(node.val)

        while stack:
            tmp = stack.pop()
            for n in tmp.neighbors:
                if n not in visited:
                    stack.append(n)
                    visited[n] = Node(n.val)
                visited[tmp].neighbors.append(visited[n])

        return visited[node]