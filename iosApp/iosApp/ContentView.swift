import SwiftUI
import shared

struct ContentView: View {
    @State var state: SampleViewState = SampleViewState()
    let viewModel = SampleViewModel()
    
	var body: some View {
        VStack {
            Text(state.time)
            Spacer().frame(height: 10)
            Text("Counter: \(state.counter)")
            Spacer().frame(height: 10)
            Button("INCREMENT", action: { viewModel.increment() })
        }
        .onAppear {
            viewModel.startClock()
            viewModel.stateFlow.collectState { value in
                state = value as! SampleViewState
            }
        }
        .onDisappear {
            viewModel.stateFlow.cancelCollect()
            viewModel.clean()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
