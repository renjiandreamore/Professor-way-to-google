```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers
@Language: Markdown
@Datetime: 16-09-14 19:08
```

private PriorityQueue<E> queue;
	private int maxSize; // 堆的最大容量

	public FixSizedPriorityQueue(int maxSize) {
		if (maxSize <= 0)
			throw new IllegalArgumentException();
		this.maxSize = maxSize;
		this.queue = new PriorityQueue(maxSize, new Comparator<E>() {
			public int compare(E o1, E o2) {
				// 生成最大堆使用o2-o1,生成最小堆使用o1-o2, 并修改 e.compareTo(peek) 比较规则
				return (o2.compareTo(o1));
			}
		});
	}

	public void add(E e) {
		if (queue.size() < maxSize) { // 未达到最大容量，直接添加
			queue.add(e);
		} else { // 队列已满
			E peek = queue.peek();
			if (e.compareTo(peek) < 0) { // 将新元素与当前堆顶元素比较，保留较小的元素
				queue.poll();
				queue.add(e);
			}
		}
	}

	public List<E> sortedList() {
		List<E> list = new ArrayList<E>(queue);
		Collections.sort(list); // PriorityQueue本身的遍历是无序的，最终需要对队列中的元素进行排序
		return list;
	}
