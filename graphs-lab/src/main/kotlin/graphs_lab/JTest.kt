package graphs_lab

fun sum(numbers: IntArray): Int {
	var result = 0
	for (number in numbers) result += number
	return result
}