SRCS = $(shell find src -type f)
LEIN = $(shell which lein || echo ./lein)

all: ./js/demo.js

node_modules: project.clj
	@echo "[NPM] Install"
	@$(LEIN) npm install

./js/%.js: $(SRCS) $(PROTOS) node_modules Makefile
	@echo "[CLJS] Compile"
	@$(LEIN) cljsbuild once standard

repl: $(SRCS) node_modules Makefile
	rlwrap $(LEIN) figwheel repl

clean:
	-@rm -rf js ||:
	-@rm -rf node_modules ||:
