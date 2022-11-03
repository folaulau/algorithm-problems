

class Node:
    def __init__(self, value:int):
        self.value = value
        self.next = None

def remove_duplicates(head:Node) -> Node:

    if head is None:
        return head

    node = head

    while node.next is not None:

        if node.value == node.next.value:
            node.next = node.next.next
        else:
            node = node.next

    return head

def print_linked_list(linked_list: Node):
    print("print_linked_list")
    while linked_list is not None:
        print("linked_list value: {}".format(linked_list.value))

        if linked_list.next is None:
            break
        else:
            linked_list = linked_list.next

node1 = Node(1)
node2 = node1.next = Node(2)
node3 = node2.next = Node(2)
node4 = node3.next = Node(3)
node5 = node4.next = Node(4)

print_linked_list(node1)
node1 = remove_duplicates(node1)
print_linked_list(node1)