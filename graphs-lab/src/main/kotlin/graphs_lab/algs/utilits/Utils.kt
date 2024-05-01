package graphs_lab.algs.utilits

import graphs_lab.core.edges.Edge
import graphs_lab.core.edges.WeightedEdge

fun <I, E : Edge<I>> edgeWeight(edge: E, defaultWeight: Number = 1): Number {
	if (edge::class == WeightedEdge::class) {
		edge as WeightedEdge<*, *>
		return edge.weight
	}
	return defaultWeight
}
