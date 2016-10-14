dtmc 

module Simple
  state: [0..4];

[] (state=0) -> 0.5:(state'=1) + 0.5:(state'=2);
[] (state=1) -> 0.5:(state'=0) + 0.5:(state'=3);
[] (state=3) -> (state'=3);
[] (state=2) -> 0.5:(state'=0) + 0.5:(state'=4);
[] (state=4) -> 0.5:(state'=2) + 0.5:(state'=4);

endmodule