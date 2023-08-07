import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int size = Integer.parseInt(br.readLine());
			String[] secret = new String[size - 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			Node root = new Node(st.nextToken());
			for (int i = 0; i < size - 1; i++) {
				secret[i] = st.nextToken();
			}
			addNodes(root, secret);// root뒤로 secret들 연결

			int query = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int times = 0; times < query; times++) {
				st.nextToken();// i빼주기
				int index = Integer.parseInt(st.nextToken());
				int addSize = Integer.parseInt(st.nextToken());
				String[] addStr = new String[addSize];

				for (int i = 0; i < addSize; i++) {// 추가할 문자열 배열로 관리
					addStr[i] = st.nextToken();
				}
				if (index == 0)
					root = addRoot(root, addStr);
				else
					addNodes(findNode(root, index - 1), addStr);// 해당위치에 노드 삽입
			}

			sb.append("#" + test_case);

			Node now = root;
			int count = 0;
			while (count < 10 && now.next != null) {// 10개까지 or null이나올떄까지 출력
				count++;
				sb.append(" " + now.str);
				now = now.next;
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}

	static Node addRoot(Node root, String[] str) {
		Node realRoot = new Node(str[0]);
		Node now = realRoot;
		for (int i = 1; i < str.length; i++) {
			now.next = new Node(str[i]);
			now = now.next;

		}
		now.next = root;
		root.before = now;
		return realRoot;

	}

	// index번째 노드 찾아오기
	static Node findNode(Node root, int index) {

		for (int times = 0; times < index; times++) {
			if (root.next != null) {
				root = root.next;
			} else {
				break;
			}
		}
		return root;
	}

	// 노드 뭉텅이로 추가
	static void addNodes(Node head, String[] str) {
		Node next = head.next;

		for (String s : str) {// 자기네들 끼리 연결
			Node now = new Node(s);
			head.addNode(now);
			now.setBefore(head);
			head = now;
		}
		// 꼬리연결
		head.next = next;
	}

	static class Node {
		Node next;
		Node before;
		String str;

		public Node(String str) {
			this.str = str;
		}

		void addNode(Node next) {
			this.next = next;
		}

		void setBefore(Node before) {
			this.before = before;
		}

	}
}
